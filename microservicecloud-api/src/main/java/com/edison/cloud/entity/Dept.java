package com.edison.cloud.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@ApiModel(description = "部門資訊",value = "Dept")
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable{ // Dept(Entity) orm 在mysql中也有一個Dept(table) 為類表關係映射 //必須序列化

	public Long deptno; //主鍵
	public String dname; //部門名稱 
	public String db_source; //來自那個資料庫，因為微服務架構可以一個服務對應一個資料庫，同一個信息被儲存到不同資料庫
}
