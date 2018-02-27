# spring工具类
> Spring-core中提供了大量的工具类，常用的有StringUtils、ObjectUtils、NumberUtils、Base64Utils等，Spring工具类在spring-core.jar中的org.springframework.util包下。

+ 1:StringUtils
方法名	              返回值类型	            作用	                        备注
```
isEmpty(Object str)	boolean	                 判断字符串是否为Null或者空字符串	null和''都为true
hasLength(CharSequence str)	boolean	         判断字符串长度是否大于1	null和''都为false
hasText(CharSequence str)	boolean	          判断字符串中是否有字符	null和空字白符都为false
containsWhitespace(CharSequence str)	boolean	              字符串中是否含有空白字符	
trimWhitespace(CharSequence str)	String	                   去掉字符串中首尾的空白字符	
trimAllWhitespace(String str)	String	去                      掉字符串中所有的空白字符	
trimLeadingWhitespace(String str)	String	                   去掉字符串左边的空白字符	
trimTrailingWhitespace(String str)	String	                   去掉字符串右边边的空白字符	
startsWithIgnoreCase(String str, String prefix)	String	       判断字符串是否以xx开头，并且忽略大小写	
getFilename(String path)	String	                          获取文件名	“mypath/myfile.txt” -> “myfile.txt”
getFilenameExtension(String path)	String	                  获取文件扩展名	“mypath/myfile.txt” -> “txt”
stripFilenameExtension(String path)	String	                 去掉文件扩展名	“mypath/myfile.txt” -> “mypath/myfile”
replace(String inString, String oldPattern, String newPattern)	String	替换字符串	
delete(String inString, String pattern)	String	            从给定的字符串中删除所有匹配的字符	
deleteAny(String inString, String charsToDelete)	String	删除所有指定字符	“az\n” will delete ‘a’s, ‘z’s and new lines
```
+ 2:ObjectUtils
```
isEmpty(Object obj)	boolean	           判断对象是否为空	对象为null或者数组Map为空等都为true
isEmpty(Object[] array)	boolean	       判断数组是否为空	
isArray(Object obj)	boolean	           判断对象是否为数组	
containsElement(Object[] array, Object element)	boolean	    判断数据组中是否包含给定的元素	
addObjectToArray(A[] array, O obj)

```
+ 3:NumberUtils
```
convertNumberToTargetClass(Number number, Class targetClass)	<T extends Number> T	将Number转为指定的类型
parseNumber(String text, Class targetClass)	<T extends Number> T	将字符串转为数值类型
parseNumber(String text, Class targetClass, NumberFormat numberFormat)	<T extends Number> T	将字符串转为数值类型
```

+ 4:Base64Utils
```
encode(byte[] src)	byte[]	编码
decode(byte[] src)	byte[]	解码
```