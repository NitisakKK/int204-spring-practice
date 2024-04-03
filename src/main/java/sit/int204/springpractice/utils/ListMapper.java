package sit.int204.springpractice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListMapper<S, T> {
    @Autowired
    ModelMapper mapper;

    public ListMapper() {}

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(entity -> mapper.map(entity, targetClass))
                .collect(Collectors.toList());
    }
}
