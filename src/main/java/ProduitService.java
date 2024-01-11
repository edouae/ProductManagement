
	import java.util.ArrayList;
	import java.util.List;

	public class ProduitService {
		 private List<Produit> products;

		    public ProduitService() {
		        this.products = new ArrayList<>();
		    }
		    public void addProduct (Produit newProduct) {
		        if (verifyById(newProduct.getId()) || verifyByName(newProduct.getNom())) {
		            System.out.println("The product exists already.");
		            return;
		        }

		        if (newProduct.getPrix() < 0 || newProduct.getQuantite() < 0) {
		            System.out.println("Please enter a positif price or quantity.");
		            return;
		        }

		        products.add(newProduct);
		        System.out.println("Product" + newProduct + "added successfully!");
		    }
		    private boolean verifyById(Long id) {
		        return products.stream().anyMatch(produit -> produit.getId().equals(id));
		    }

		    private boolean verifyByName(String name) {
		        return products.stream().anyMatch(produit -> produit.getNom().equalsIgnoreCase(name));
		    }
		    
	}

