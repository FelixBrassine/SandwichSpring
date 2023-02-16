package be.technobel.fbrassine.sandwichspring.service.impl;

import be.technobel.fbrassine.sandwichspring.exceptions.NotFoundException;
import be.technobel.fbrassine.sandwichspring.models.dto.PanierDTO;
import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Panier;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.models.entity.User;
import be.technobel.fbrassine.sandwichspring.models.form.PanierInsertForm;
import be.technobel.fbrassine.sandwichspring.repository.PanierRepository;
import be.technobel.fbrassine.sandwichspring.repository.SandwichRepository;
import be.technobel.fbrassine.sandwichspring.repository.UserRepository;
import be.technobel.fbrassine.sandwichspring.service.PanierService;
import be.technobel.fbrassine.sandwichspring.service.SandwichService;
import be.technobel.fbrassine.sandwichspring.service.mapper.PanierMapper;
import be.technobel.fbrassine.sandwichspring.service.mapper.SandwichMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PanierServiceImpl implements PanierService {
    private final PanierRepository panierRepository;
    private final PanierMapper mapper;
    private final SandwichMapper sandwichMapper;
    private final SandwichRepository sandwichRepository;
    private final SandwichService sandwichService;
    private final UserRepository userRepository;

    public PanierServiceImpl(PanierRepository panierRepository, PanierMapper mapper,
                             SandwichMapper sandwichMapper,
                             SandwichRepository sandwichRepository, SandwichService sandwichService,
                             UserRepository userRepository) {
        this.panierRepository = panierRepository;
        this.mapper = mapper;
        this.sandwichMapper = sandwichMapper;
        this.sandwichRepository = sandwichRepository;
        this.sandwichService = sandwichService;
        this.userRepository = userRepository;
    }

    @Override
    public PanierDTO getOne(long id) {
        PanierDTO panierDTO = panierRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Sandwich not found"));
        double total = panierRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Sandwich not found"))
                .getSandwiches().stream()
                .mapToDouble(Sandwich::getPrice)
                .sum();
        panierDTO.setTotal(total);
        return panierDTO;

    }

    @Override
    public List<SandwichDTO> getAllSand(Long id) {
        Panier p = panierRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Panier not found") );

        return p.getSandwiches().stream()
                .map(sandwichMapper::toDto)
                .toList();
    }

    @Override
    public void addSand(Long id) {
        Sandwich s = sandwichRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Sandwich not found")
        );
        User u = userRepository.getOne(1L);
        Panier entity = u.getPanier();
        Set<Sandwich> sandwichSet = entity.getSandwiches();
        if (sandwichSet.contains(s)){



        }
        sandwichSet.add(s);
        entity.setSandwiches(sandwichSet);

        panierRepository.save(entity);
    }
    @Override
    public void delete(Long id) {
        Sandwich s = sandwichRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Sandwich not found")
                );
        User u = userRepository.getOne(1L);
        Panier entity = u.getPanier();
        Set<Sandwich> sandwichSet = entity.getSandwiches();
        if (sandwichSet.contains(s)){
            sandwichSet.remove(s);
        }else {
            throw  new NotFoundException("Sandwich not found");
        }
        entity.setSandwiches(sandwichSet);
        panierRepository.save(entity);
    }
}
