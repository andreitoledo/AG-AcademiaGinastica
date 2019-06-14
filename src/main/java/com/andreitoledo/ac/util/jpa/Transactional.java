package com.andreitoledo.ac.util.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/*Diz que é um interceptador do CDI, por isso consigo interceptar um método,
abrir a transação e depois fazer um commit ou rollback*/
@InterceptorBinding

/*Fala que a anotação que estamos criando é pra ser interpretada em tempo de execução*/
@Retention(RetentionPolicy.RUNTIME)

/*Diz que podemos usar a anotação tanto em uma classe ou método*/
@Target({ ElementType.TYPE, ElementType.METHOD })

public @interface Transactional {

}