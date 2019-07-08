# base项目介绍
>    common:封装了统一返回数据格式和各种异常
```java
        /**
        * 正常返回
        */
        Result<dataType> r = Result.generate(ResultEnum.OK, data);
        r = Result.generate(ResultEnum.OK);
        r = Result.generateSuccess(data);
        
        /**
        * 错误时返回，若ResultEnum没有你想要枚举值，可在枚举中自行添加
        */
        r = Result.generate(ResultEnum.AUTH_FAIL);
```

>   configuration: 封装了controller层的统一异常处理
```java
        /**
        * 未单独定义的运行时异常类型在此统一处理
        */
        @ExceptionHandler(RuntimeException.class)
        @ResponseBody
        public Result exHandler(RuntimeException ex) {
            return forException(ResultEnum.SYSTEM_EXCEPTION_ERROR, ex);
        }
    
        /**
        * 默认定义了以下异常类型，若需要单独定义异常类型，请在此项目exception下添加，需继承BaseException
        * 然后在GlobalExceptionAdvice添加 exceptionhandler
        */
        @ExceptionHandler(BusinessException.class)
        @ResponseBody
        public Result bizExHandler(BusinessException ex) {
            return forException(ResultEnum.BUSINESS_FAIL, ex);
        }
    
        @ExceptionHandler(IllegalParamException.class)
        public Result argHandler(IllegalParamException ex) {
            return forException(ResultEnum.ILLEGAL_PARAM, ex);
        }
    
        @ExceptionHandler(AuthException.class)
        public Result authHandler(AuthException ex) {
            return forException(ResultEnum.AUTH_FAIL, ex);
        }
```

>   entity:仅封装了一个基础的baseEntity，根据mybatisplus相关，创建数据库实体类请继承该类