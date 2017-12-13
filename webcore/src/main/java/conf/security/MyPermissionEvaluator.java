package conf.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * Created by Alex on 12.12.2017.
 */
public class MyPermissionEvaluator implements PermissionEvaluator{
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {

        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return true;
    }
}
