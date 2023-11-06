package com.prestacao.servicoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CredenciaisDto {
	private String username;
	private String senha;

}
