package com.prestacao.servicoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenDto {
	private String username;
	private String token;
}
