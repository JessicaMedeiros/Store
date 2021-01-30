package io.github.jessicamedeiros.store;

import io.github.jessicamedeiros.store.enums.ClientType;
import io.github.jessicamedeiros.store.enums.PaymentStatus;
import io.github.jessicamedeiros.store.model.*;
import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.model.payment.PaymentByBoleto;
import io.github.jessicamedeiros.store.model.payment.PaymentByCard;
import io.github.jessicamedeiros.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Autowired
	private CategoryRepository repoCat;
	@Autowired
	private ProductRepository repoProd;
	@Autowired
	private StateRepository repoState;
	@Autowired
	private CityRepository repoCity;
	@Autowired
	private ClientRepository repoClient;
	@Autowired
	private AddressRepository repoAddress;
    @Autowired
    private LineItemRepository repoLItem;
    @Autowired
    private PaymentRepository repoPay;
    @Autowired
    private OrderRepository repoOrder;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);

		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().add(cat1);
		repoCat.saveAll(Arrays.asList(cat1, cat2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));

		State est1 = new State(null, "alagoas");
		State est2 = new State(null, "minas gerais");

		City c1 = new City(null, "maceio", est1);
		City c2 = new City(null, "arapiraca", est1);
		City c3 = new City(null, "belo horizonte", est2);

		est1.getCities().addAll(Arrays.asList(c1,c2));
		est2.getCities().addAll(Arrays.asList(c3));

		repoState.saveAll(Arrays.asList(est1, est2));
		repoCity.saveAll(Arrays.asList(c1, c2, c3));

		Client cl1 = new Client(null, "Maria", "m@gmail.com", "43434343", ClientType.PESSOAFISICA);
		cl1.getTelephone().addAll(Arrays.asList("54353534", "34534534534"));
		Address a1 = new Address(null, "Rua", "30232","apewew", "ja", "434234", cl1, c1);
		Address a2 = new Address(null, "Rsdsua", "3025432","afsdfsdfpewew", "jafsd", "430934", cl1, c2);

		cl1.getAddresses().addAll(Arrays.asList(a1,a2));

		repoClient.saveAll(Arrays.asList(cl1));
		repoAddress.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:32"), cl1, a1);
		Order ped2 = new Order(null, sdf.parse("10/10/2017 19:35"), cl1, a2);

		Payment pagto1 = new PaymentByCard(null, PaymentStatus.QUITADO, ped1, 6);
        ped1.setPayment(pagto1);

        Payment pagto2 = new PaymentByBoleto(null, PaymentStatus.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPayment(pagto2);

        cl1.getOrders().addAll(Arrays.asList(ped1, ped2));

        repoOrder.saveAll(Arrays.asList(ped1, ped2));
		repoPay.saveAll(Arrays.asList(pagto1, pagto2));


		LineItem li1 = new LineItem(ped1, p1, 0.00, 1, 200.00);
		LineItem li2 = new LineItem(ped1, p3, 0.00, 2, 200.00);
		LineItem li3 = new LineItem(ped2, p3, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(li1));
		ped2.getItems().addAll(Arrays.asList(li3));

		p1.getItems().addAll(Arrays.asList(li1));
		p2.getItems().addAll(Arrays.asList(li3));
		p3.getItems().addAll(Arrays.asList(li2));


		repoLItem.saveAll(Arrays.asList(li1, li2, li3)).getClass();

	}



}
