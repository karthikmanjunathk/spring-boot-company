package com.innoventes.test.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	@NotBlank
	@Size(min = 5, message = "{validation.name.size.too_short}")
	private String companyName;

	@Email(message = "Please provide a valid email address")
	private String email;

	@EvenNumberOrZero
	private Integer strength;

	private String webSiteURL;

	@UniqueFieldValidator
	private String companyCode;
}
