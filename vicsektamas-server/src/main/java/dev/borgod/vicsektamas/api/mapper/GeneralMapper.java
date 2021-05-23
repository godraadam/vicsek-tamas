package dev.borgod.vicsektamas.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface GeneralMapper<D, M> {
    D createDTO(M model);
    M createModel(D dto);

    default List<D> createDTOList(List<M> models) {
        return models.stream().map(m -> createDTO(m)).collect(Collectors.toList());
    }

    default List<M> createModelList(List<D> dtos) {
        return dtos.stream().map(d -> createModel(d)).collect(Collectors.toList());
    }

}
