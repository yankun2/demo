package com.example.demo.enum2;

public enum SexEnum {

    /**
     *0, "男"
     */
    MALE(0, "男"),
    /**
     * 1, "女"
     */
    FEMALE(1, "女")
    ;
    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static SexEnum byCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (SexEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.code + "";
    }
}