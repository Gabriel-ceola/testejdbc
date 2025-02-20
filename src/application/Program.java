package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== Teste 1 - seller findById ====");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n==== Teste 2 - seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n==== Teste 3 - seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n==== Teste 4 - seller insert ====");
		Seller newSeller = new Seller(null, "Gabriel", "gabriel@gmail.com", new Date(), 2700.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id: " + newSeller.getId());

		System.out.println("\n==== Teste 5 - seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Fabiana");
		sellerDao.update(seller);
		System.out.println("Atualizado!");

		System.out.println("\n==== Teste 6 - seller delete ====");
		System.out.println("Id to delete");
		int id = sc.nextInt();
		sellerDao.deletById(id);
		System.out.println("Deleted");
		sc.close();
	}

}
