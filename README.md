# @ControllerAdvice 或 @RestControllerAdvice
### 使用`@ControllerAdvice`（本质也是一个AOP实现） 注解来增强 所有的 `@RequestMapping`标记的方法；  
It is typically used to define `@ExceptionHandler` ,`@InitBinder`, and `@ModelAttribute` methods that apply to all `@RequestMapping` methods.

# @ExceptionHandler
- 只能声明方法；
- 与`@ControllerAdvice`结合使用，可以用于增强所有 `@RequestMapping`方法的异常处理；
