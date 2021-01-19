package com.fly.common;
import com.fly.common.codeGeneration.GeneratorDataSourceCode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartUp {
    public static void main(String[] args) {
        GeneratorDataSourceCode generatorDataSourceCode =new GeneratorDataSourceCode();
        generatorDataSourceCode.runGeneratorCode();
    }
}
