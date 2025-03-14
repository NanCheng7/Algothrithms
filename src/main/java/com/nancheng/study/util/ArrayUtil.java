package com.nancheng.study.util;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public class ArrayUtil {

    private static final String COMMA_SPLIT = ",";

    private static final String VALUE_OF_METHOD = "valueOf";

    /**
     * 通过逗号分隔的字符串构建数组，传入类型字节码
     *
     * @param str
     * @param clazz
     * @param <R>
     * @return
     */
    public static <R> R[] buildArrayFromStrByCommaSplit(String str, Class<R> clazz) {
        return buildArrayFromArrByMethod(str.split(COMMA_SPLIT), String.class, clazz, VALUE_OF_METHOD);
    }

    private static <T, R> R[] buildArrayFromArrByMethod(T[] originArr, Class<T> tClass, Class<R> rClazz, String methodName) {
        if (originArr == null || methodName == null || methodName.isEmpty()) {
            throw new IllegalArgumentException("Error method args");
        }
        Method method;
        try {
            method = rClazz.getMethod(methodName, tClass);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        List<R> resList = new ArrayList<R>();
        for (T t : originArr) {
            try {
                R v = (R) method.invoke(null, t);
                resList.add(v);
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        R[] res = (R[]) Array.newInstance(rClazz, originArr.length);
        return resList.toArray(res);
    }

    /**
     * 解析二维字符串数组为指定对象二维数组
     * [[0,1],[0,2]] ===>  |0,1|
     * |0,2|
     *
     * @param str
     * @param clazz
     * @param <R>
     * @return
     */
    public static <R> R[][] build2DArrayFromStrByCommaSplit(String str, Class<R> clazz) {
        return build2DArrayFromArrByMethod(parseStringTo2DArray(str), String.class, clazz, VALUE_OF_METHOD);
    }


    private static <T, R> R[][] build2DArrayFromArrByMethod(T[][] originArr, Class<T> tClass, Class<R> rClazz, String methodName) {
        if (originArr == null || methodName == null || methodName.isEmpty()) {
            throw new IllegalArgumentException("Error method args");
        }

        Method method;
        try {
            method = rClazz.getMethod(methodName, tClass);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Method not found: " + methodName, e);
        }

        List<List<R>> resultList = new ArrayList<>();
        for (T[] row : originArr) {
            List<R> rowList = new ArrayList<>();
            for (T t : row) {
                try {
                    @SuppressWarnings("unchecked")
                    R value = (R) method.invoke(null, t);
                    rowList.add(value);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Failed to invoke method: " + methodName, e);
                }
            }
            resultList.add(rowList);
        }

        @SuppressWarnings("unchecked")
        R[][] resultArray = (R[][]) java.lang.reflect.Array.newInstance(rClazz, resultList.size(), originArr[0].length);
        for (int i = 0; i < resultList.size(); i++) {
            List<R> rowList = resultList.get(i);
            resultArray[i] = rowList.toArray((R[]) java.lang.reflect.Array.newInstance(rClazz, rowList.size()));
        }

        return resultArray;
    }

    private static String[][] parseStringTo2DArray(String input) {
        // 去掉外层的中括号
        input = input.trim().substring(1, input.length() - 1);

        // 分割内部数组
        String[] rows = input.split("\\],\\s*\\[");
        String[][] result = new String[rows.length][];

        // 解析每个内部数组
        for (int i = 0; i < rows.length; i++) {
            // 去掉每个内部数组的中括号
            String row = rows[i].replace("[", "").replace("]", "");
            // 按逗号分割元素
            String[] elements = row.split(",");
            result[i] = elements;
        }
        return result;
    }

    /**
     * 数组拆包
     * @param sourceArray
     * @param targetType
     * @return
     */
    public static Object convertArray(Object sourceArray, Class<?> targetType) {
        if (sourceArray == null) {
            return null;
        }

        Class<?> sourceClass = sourceArray.getClass();
        if (!sourceClass.isArray()) {
            throw new IllegalArgumentException("Source must be an array");
        }

        int length = Array.getLength(sourceArray);
        Class<?> sourceComponentType = sourceClass.getComponentType();

        if (sourceComponentType.isArray()) {
            // 递归处理多维数组
            Class<?> targetComponentType = getArrayType(targetType);
            Object targetArray = Array.newInstance(targetComponentType, length);
            for (int i = 0; i < length; i++) {
                Object element = Array.get(sourceArray, i);
                Object converted = convertArray(element, targetType);
                Array.set(targetArray, i, converted);
            }
            return targetArray;
        } else {
            // 处理最内层元素
            return convertPrimitiveArray(sourceArray, targetType, length);
        }
    }

    private static Object convertPrimitiveArray(Object sourceArray, Class<?> targetType, int length) {
        Class<?> wrapperType = getWrapperType(targetType);
        if (!wrapperType.isAssignableFrom(sourceArray.getClass().getComponentType())) {
            throw new IllegalArgumentException("Type mismatch between source and target");
        }

        Object targetArray = Array.newInstance(targetType, length);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(sourceArray, i);
            Array.set(targetArray, i, unwrap(element, targetType));
        }
        return targetArray;
    }

    private static Class<?> getArrayType(Class<?> componentType) {
        return Array.newInstance(componentType, 0).getClass();
    }

    private static Class<?> getWrapperType(Class<?> primitiveType) {
        if (primitiveType == int.class) return Integer.class;
        if (primitiveType == double.class) return Double.class;
        if (primitiveType == long.class) return Long.class;
        if (primitiveType == float.class) return Float.class;
        if (primitiveType == boolean.class) return Boolean.class;
        if (primitiveType == byte.class) return Byte.class;
        if (primitiveType == short.class) return Short.class;
        if (primitiveType == char.class) return Character.class;
        throw new IllegalArgumentException("Unsupported primitive type: " + primitiveType);
    }

    private static Object unwrap(Object wrapper, Class<?> targetType) {
        if (targetType == int.class) return ((Integer) wrapper).intValue();
        if (targetType == double.class) return ((Double) wrapper).doubleValue();
        if (targetType == long.class) return ((Long) wrapper).longValue();
        if (targetType == float.class) return ((Float) wrapper).floatValue();
        if (targetType == boolean.class) return ((Boolean) wrapper).booleanValue();
        if (targetType == byte.class) return ((Byte) wrapper).byteValue();
        if (targetType == short.class) return ((Short) wrapper).shortValue();
        if (targetType == char.class) return ((Character) wrapper).charValue();
        throw new IllegalArgumentException("Unsupported target type: " + targetType);
    }

    /**
     * 解析str ==>  多维列表
     * @param input
     * @param targetType
     * @param elementConverter
     * @return
     * @param <T>
     */
    public static <T> T parseNestedList(String input, Type targetType, Function<String, ?> elementConverter) {
        input = input.trim();
        return (T) parse(input, targetType, elementConverter);
    }

    private static Object parse(String str, Type type, Function<String, ?> elementConverter) {
        str = str.trim();
        if (str.startsWith("[")) {
            // 处理列表类型
            if (!(type instanceof ParameterizedType)) {
                throw new IllegalArgumentException("Expected List type but got: " + type);
            }

            ParameterizedType pType = (ParameterizedType) type;
            Type rawType = pType.getRawType();
            if (rawType != List.class) {
                throw new IllegalArgumentException("Unsupported container type: " + rawType);
            }

            Type elementType = pType.getActualTypeArguments()[0];
            List<Object> list = new ArrayList<>();

            // 分割外层元素
            String content = str.substring(1, str.length() - 1).trim();
            if (content.isEmpty()) {
                return list;
            }

            for (String elementStr : splitTopLevel(content)) {
                list.add(parse(elementStr, elementType, elementConverter));
            }
            return list;

        } else {
            // 处理最内层元素
            return elementConverter.apply(str);
        }
    }

    private static List<String> splitTopLevel(String str) {
        List<String> result = new ArrayList<>();
        int bracketCount = 0;
        StringBuilder current = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '[') bracketCount++;
            else if (c == ']') bracketCount--;

            if (c == ',' && bracketCount == 0) {
                result.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        if (current.length() != 0) {
            result.add(current.toString().trim());
        }
        return result;
    }

}
