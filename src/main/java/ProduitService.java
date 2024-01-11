
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
		    
		    public void readProducts() {
		        if (products.isEmpty()) {
		            System.out.println("No products available.");
		        } else {
		            System.out.println("List of products:");
		            for (Produit product : products) {
		                System.out.println(product);
		            }
		        }
		    }
		    public void updateProduct(Produit product) 
		    { 
		    try {
		        if (!verifyById(product.getId())) 
		        {
		        	throw new IllegalArgumentException("Can't find product with the ID :" + product.getId());
		        }
		     
		        if (product.getPrix() < 0 || product.getQuantite() < 0) 
		        {
		            System.out.println("Price and quantity have to be positive numbers.");
		            return;
		        }

		        for (int i = 0;i< products.size();i++) 
		        {
		            Produit produit = products.get(i);
		            if (produit.getId().equals(product.getId())) 
		            {
		            	products.set(i,product);
		                System.out.println("Product " + product +" updated successfully !");
		                return;
		            }
		        }
		    }
		    catch (IllegalArgumentException e) 
		    {
		        System.out.println(e.getMessage());
		    }
		   }
		    
		   

	}

