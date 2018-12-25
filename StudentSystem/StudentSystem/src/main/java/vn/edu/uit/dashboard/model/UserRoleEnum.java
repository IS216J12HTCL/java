package vn.edu.uit.dashboard.model;


public enum UserRoleEnum {
	ADMIN(1),
	USER(2),
	TEACHER(3),
	
	UNKNOW(0);
	
	private final int value;
    private UserRoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}