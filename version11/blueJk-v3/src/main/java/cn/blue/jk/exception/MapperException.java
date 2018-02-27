package cn.blue.jk.exception;

import cn.blue.common.exception.MapperEnum;

public class MapperException extends RuntimeException {
    public MapperException() {
        super("" + MapperEnum.MAPPER_ENUM.getVar());
    }
}
