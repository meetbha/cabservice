package com.cabservice.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Getter;
import lombok.Setter;

@Component
@RequestScope
@Getter
@Setter
public class TokenDto {

	private String userName;

	private String name;

}
