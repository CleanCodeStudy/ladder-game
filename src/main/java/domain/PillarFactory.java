package domain;

import domain.direction.Direction;
import domain.direction.DirectionGenerator;
import dto.UserInputDto;

import java.util.List;
import java.util.stream.Collectors;

public class PillarFactory {

    private UserInputDto inputDto;

    public PillarFactory(UserInputDto inputDto) {
        this.inputDto = inputDto;
    }

    public List<Pillar> createPillar(DirectionGenerator directionGenerator) {
        List<User> users = inputDto.toEntities();
        List<Pillar> pillars = users.stream()
                .map(user -> new Pillar(user, directionGenerator))
                .collect(Collectors.toList());
        syncPillar(pillars);
        return pillars;
    }

    private void syncPillar(List<Pillar> pillars) {
        for (int idx = 0; idx < pillars.size(); idx++) {
            //오른쪽이동 -> 오른쪽 기둥은 왼쪽이동으로
            //왼쪽이동 -> 왼쪽 기둥은 오른쪽이동으로
        }

    }

    private void changeDirection(Pillar pillar,int idx){
        if(pillar.getDirections().get(idx)==Direction.RIGHT){

        }
    }


}
