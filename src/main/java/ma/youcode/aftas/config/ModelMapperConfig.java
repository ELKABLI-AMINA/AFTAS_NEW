package ma.youcode.aftas.config;

import ma.youcode.aftas.dto.CreateUpdateCompetitionDto;
import ma.youcode.aftas.entity.Competition;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(CreateUpdateCompetitionDto.class, Competition.class)
                .addMappings(mapper -> {
                    mapper.using(ctx -> convertToLocalDateTime(ctx.getSource())).map(CreateUpdateCompetitionDto::getStartTime, Competition::setStartTime);
                    mapper.using(ctx -> convertToLocalDateTime(ctx.getSource())).map(CreateUpdateCompetitionDto::getEndTime, Competition::setEndTime);
                });

        return modelMapper;
    }

    private LocalDateTime convertToLocalDateTime(Object source) {
        if (source instanceof String) {
            try {
                return LocalDateTime.parse((String) source);
            } catch (DateTimeParseException e) {
                // Handle parsing errors
                return null;
            }
        }
        return null;
    }
}
