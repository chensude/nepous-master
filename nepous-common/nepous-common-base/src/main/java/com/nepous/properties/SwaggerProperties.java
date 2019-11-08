
package com.nepous.properties;

import lombok.Data;


@Data
public class SwaggerProperties {

	private String title;

	private String description;

	private String version = "1.0";

	private String license = "Apache License 2.0";

	private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

	private String contactName = "陈苏德";

	private String contactUrl = "https://github.com/chensude";

	private String contactEmail = "18112925131@163.com";
}
