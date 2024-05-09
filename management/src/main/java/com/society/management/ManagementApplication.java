package com.society.management;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.society.management.Repository.OwnerRepo;
import com.society.management.entity.OwnerEntity;

@SpringBootApplication
@EntityScan(basePackages = "com.society.management.entity")
public class ManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ManagementApplication.class, args);
		OwnerRepo ownerRepo =context.getBean(OwnerRepo.class);
		
//		OwnerEntity owner=new OwnerEntity();
//		owner.setEmail("singhakhilesh110302@gmail.com");
//		owner.setFullName("singh akhilesh vijay");
//		owner.setPhoneNumber1("9327990457");
//		owner.setPhoneNumber2("9327990457");
//		ownerRepo.save(owner);
//		
//		OwnerEntity owner1=new OwnerEntity();
//		owner.setEmail("singhakhilesh110302@gmail.com");
//		owner.setFullName("singh akhilesh ");
//		owner.setPhoneNumber1("9327990457");
//		owner.setPhoneNumber2("9327990457");
//		ownerRepo.save(owner);
//		
//		OwnerEntity owner2=new OwnerEntity();
//		owner.setEmail("singhakhilesh110302@gmail.com");
//		owner.setFullName("singh  vijay");
//		owner.setPhoneNumber1("9327990457");
//		owner.setPhoneNumber2("9327990457");
//		
//		List<OwnerEntity> list = List.of(owner,owner1,owner2);
//		ownerRepo.saveAll(list);
//		System.out.print(owner.getEmail());
//		 Optional<OwnerEntity> optional  = ownerRepo.findById(14);
//		 OwnerEntity owner=optional.get();
//		 owner.setFullName("Akki");
//		 ownerRepo.save(owner);
	}

}
