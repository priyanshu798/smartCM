package com.scm.smartCM.helpers;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException() {
        super("Resource not found");
    }
}
