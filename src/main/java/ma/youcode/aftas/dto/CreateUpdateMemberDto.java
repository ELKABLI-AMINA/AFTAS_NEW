package ma.youcode.aftas.dto;

import lombok.Data;
import ma.youcode.aftas.enums.IdentityDocumentType;

import java.util.Date;

@Data
public class CreateUpdateMemberDto {
    private Integer num;
    private String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
}
