package com.ills.dto;

import com.ills.entities.Person;
import com.ills.entities.User;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonDTO {

    public PersonDTO(){

    }

    /*public PersonDTO(Person person) {

        Map<String, Method> personGetMethods =GET_SET_METHODS.get(person.getClass()).get("get");
        Map<String, Method> personDtoSetMethods =GET_SET_METHODS.get(this.getClass()).get("set");

        for (Map.Entry<String, Method> entry : personGetMethods.entrySet()) {
            String getMethod = entry.getKey();
            String setMethod = getMethod.replace("get", "set");

            Method personGetMethod = entry.getValue();
            Method personDtoSetMethod = personDtoSetMethods.get(setMethod);
            if (personDtoSetMethod != null){
                Class[] types = personDtoSetMethod.getParameterTypes();
                Class returnType = personGetMethod.getReturnType();
                if (returnType != null && types != null && types.length == 1){
                    Class setType =types[0];
                    if (returnType.equals(setType)){

                        try{
                            Object o = personGetMethod.invoke(person);
                            if (o != null){
                                personDtoSetMethod.invoke(this, o);
                            }
                        } catch (Exception e){
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }
    }*/

    /*public static void main(String ...args) throws Exception{
        Person person = new Person();
        person.setDob(new Date());
        person.setFirstName("Aliaksey");
        person.setLastName("Drapun");
        person.setHomePhone("123");
        person.setUser(new User());

        PersonDTO dto = new PersonDTO(person);

        Map<String, Method> personGetMethods =GET_SET_METHODS.get(person.getClass()).get("get");
        Map<String, Method> personDtoSetMethods =GET_SET_METHODS.get(PersonDTO.class).get("set");

        for (Map.Entry<String, Method> entry : personGetMethods.entrySet()) {
            String getMethod = entry.getKey();
            String setMethod = getMethod.replace("get", "set");

            Method personGetMethod = entry.getValue();
            Method personDtoSetMethod = personDtoSetMethods.get(setMethod);
            if (personDtoSetMethod != null){
                Class[] types = personDtoSetMethod.getParameterTypes();
                Class returnType = personGetMethod.getReturnType();
                if (returnType != null && types != null && types.length == 1){
                    Class setType =types[0];
                    if (returnType.equals(setType)){
                        Object o = personGetMethod.invoke(person);
                        if (o != null){
                            personDtoSetMethod.invoke(dto, o);
                        }

                    }
                }
            }
        }

        System.out.println(dto.toString());

    }*/

    /*private static final Map<Class, Map<String, Map<String, Method>>> GET_SET_METHODS;
    static {
        GET_SET_METHODS = new HashMap<>();
        Stream<Method> psnMethodStream = Arrays.stream(Person.class.getDeclaredMethods());
        Map<String, Method> personGetMethodMap = getMethodFromClassByPrefix(Person.class, "get");
        Map<String, Method> personSetMethodMap = getMethodFromClassByPrefix(Person.class, "set");
        Map<String, Map<String, Method>> perosnMap = new HashMap<>();
        perosnMap.put("get", personGetMethodMap);
        perosnMap.put("set", personSetMethodMap);

        Map<String, Method> personDtoGetMethodMap = getMethodFromClassByPrefix(PersonDTO.class, "get");
        Map<String, Method> personDtoSetMethodMap = getMethodFromClassByPrefix(PersonDTO.class, "set");
        Map<String, Map<String, Method>> perosnDtoMap = new HashMap<>();
        perosnDtoMap.put("get", personDtoGetMethodMap);
        perosnDtoMap.put("set", personDtoSetMethodMap);
        GET_SET_METHODS.put(Person.class, perosnMap);
        GET_SET_METHODS.put(PersonDTO.class, perosnDtoMap);
    }*/

    /*private static Map<String, Method> getMethodFromClassByPrefix(Class clazz, String prefix){
        Stream<Method> methodStream = Arrays.stream(clazz.getDeclaredMethods());
        Stream<Method> filteredMethodStream = methodStream.filter(method -> method.getName().startsWith(prefix));
        Map<String, Method> methodMap = filteredMethodStream.collect(Collectors.toMap(Method::getName, method -> method));
        return methodMap;
    }*/

    private Long oid;

    private String firstName;

    private String lastName;

    private Date dob;

    private String homePhone;

    private UserDTO user;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "oid=" + oid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", homePhone='" + homePhone + '\'' +
                ", user=" + user +
                '}';
    }
}
