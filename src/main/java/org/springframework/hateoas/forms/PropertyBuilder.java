package org.springframework.hateoas.forms;

import org.springframework.hateoas.mvc.ControllerFormBuilder;

/**
 * Builder used by {@link ControllerFormBuilder} to create instances of {@link Property}
 * 
 */
public class PropertyBuilder {

	private String name;

	// we want to idenfify if user has setted the readonly value (default value is not false)
	private Boolean readonly;

	private boolean templated;

	private String value;

	private String prompt;

	private String regex;

	private Class<?> declaringClass;

	protected FormBuilder formBuilder;

	private SuggestBuilderProvider suggestBuilderConfigurer;

	public PropertyBuilder(String name, Class<?> declaringClass, FormBuilder formBuilder) {
		this.name = name;
		this.declaringClass = declaringClass;
		this.formBuilder = formBuilder;
	}

	public PropertyBuilder readonly(boolean readonly) {
		this.readonly = readonly;
		return this;
	}

	public SuggestBuilderProvider suggest() {
		this.suggestBuilderConfigurer = new SuggestBuilderProvider();
		return this.suggestBuilderConfigurer;
	}

	public Property build() {
		return new Property(name, readonly, templated, value, prompt, regex,
				suggestBuilderConfigurer != null ? suggestBuilderConfigurer.build() : null);
	}

	public Class<?> getDeclaringClass() {
		return declaringClass;
	}

	public PropertyBuilder regex(String regex) {
		this.regex = regex;
		return this;
	}

	public PropertyBuilder prompt(String prompt) {
		this.prompt = prompt;
		return this;
	}

	public PropertyBuilder value(String value) {
		this.value = value;
		this.templated = isTemplatedValue(value);
		return this;
	}

	private boolean isTemplatedValue(String value) {
		return value.startsWith("{") && value.endsWith("}");
	}
}