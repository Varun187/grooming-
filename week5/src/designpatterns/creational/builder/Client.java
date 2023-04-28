package designpatterns.creational.builder;

import java.time.LocalDate;

import designpatterns.creational.builder.UserDTO.UserDTOBuilder;

public class Client {
    public static void main(String[] args) {
        User user = createUser();
        // Client has to provide director with concrete builder
        UserDTO dto = directBuild(UserDTO.getBuilder(), user);
        System.out.println(dto);
    }

    /**
     * This method serves the role of director in builder pattern.
     */
    private static UserDTO directBuild(UserDTOBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
                .withBirthday(user.getBirthday()).withAddress(user.getAddress()).build();
    }

    /**
     * Returns a sample user.
     */
    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1990, 3, 1));
        user.setFirstName("Ram");
        user.setLastName("Kumar");
        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("native Street");
        address.setCity("Ooty");
        address.setState("TN");
        address.setZipcode("67998");
        user.setAddress(address);
        return user;
    }
}
