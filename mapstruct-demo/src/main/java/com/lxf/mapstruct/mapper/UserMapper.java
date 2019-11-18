package com.lxf.mapstruct.mapper;

import com.lxf.mapstruct.model.Student;
import com.lxf.mapstruct.model.User;
import com.lxf.mapstruct.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @program: mapstruct-demo
 * @description:
 * @Mapper注解的componentModel属性
 *
 * componentModel属性用于指定自动生成的接口实现类的组件类型。这个属性支持四个值：
 *
 * default: 这是默认的情况，mapstruct不使用任何组件类型, 可以通过Mappers.getMapper(Class)方式获取自动生成的实例对象。
 *
 * cdi: the generated mapper is an application-scoped CDI bean and can be retrieved via @Inject
 *
 * spring: 生成的实现类上面会自动添加一个@Component注解，可以通过Spring的 @Autowired方式进行注入
 *
 * jsr330: 生成的实现类上会添加@javax.inject.Named 和@Singleton注解，可以通过 @Inject注解获取。
 * @author: lxf
 * @create: 2019-11-18 16:05
 **/
@Mapper(componentModel="spring")
public interface UserMapper {

    /**
     * dto转user
     * @param userDto
     * @return
     */
     User getUser(UserDto userDto);

    /**
     * user 转dto
     * @param user
     * @return
     */
     UserDto getUserDto(User user);


    /**
     * dto转userV2 ignore 返回的时候忽略，
     * @param userDto
     * @return
     */
     @Mappings(
             {
                     //字段名称不一样的转换
                     @Mapping(source = "passWord",target = "pass"),
                     @Mapping(target = "id" ,ignore = true)

             }
     )
     User getUserV2(UserDto userDto);


    /**
     * 多对一转换
     * @param user
     * @param userDto
     * @return
     */
    @Mappings(
            {
                    @Mapping(source = "user.id",target = "id"),
                    @Mapping(source = "userDto.name" ,target = "name"),
                    @Mapping(source = "userDto.passWord" ,target = "pass"),
                    @Mapping(source = "userDto.mail" ,target = "mail")

            }
    )
   Student getStudent(User user, UserDto userDto);

}
