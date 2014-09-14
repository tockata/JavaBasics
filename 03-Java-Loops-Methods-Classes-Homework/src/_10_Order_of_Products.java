import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;


public class _10_Order_of_Products {

	public static void main(String[] args) {
		ArrayList<Product> productsList = new ArrayList<Product>();
		ArrayList<Product> order = new ArrayList<Product>();
		productsList = readProductsFromFile(productsList);
		order = readOrderFromFile(productsList);
		
		BigDecimal total = BigDecimal.ZERO;
		for (Product product : order) {
			total = total.add(product.calcOrder());
		}
		total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		writeTotalToFile(total);

	}

	private static void writeTotalToFile(BigDecimal total) {
		BufferedWriter fileWriter = null;
		
		try {
			File file = new File("src/10_Output.txt");
			file.createNewFile();
			fileWriter = new BufferedWriter(new FileWriter(file));
			fileWriter.write(total.toString());
		} catch (IOException ioex) {
			System.err.println("Error writing the file!");
		} finally {
			try {
				fileWriter.close();
			} catch (IOException ioex) {
				System.err.println("Error closing fileWriter!");;
			}
		}
		
	}

	private static ArrayList<Product> readOrderFromFile(ArrayList<Product> order) {
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader("src/10_Order.txt"));
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				String[] splittedLine = line.split(" ");
				for (int i = 0; i < order.size(); i++) {
					if (order.get(i).getName().equals(splittedLine[1])) {
						BigDecimal quantity = order.get(i).getOrderedQuantity();
						BigDecimal newQuantity = quantity.add(new BigDecimal(splittedLine[0]));
						order.get(i).setOrderedQuantity(newQuantity);
						break;
					}
				}
			}
		} catch (IOException ioex) {
			System.err.println("Error reading the file!");
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Error closing the fileReader!");
				}
			}
		}
		return order;
	}

	private static ArrayList<Product> readProductsFromFile(ArrayList<Product> productsList) {
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader("src/10_Products.txt"));
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				String[] splittedLine = line.split(" ");
				Product product = new Product();
				product.setName(splittedLine[0]);
				product.setPrice(new BigDecimal(splittedLine[1]));
				product.setOrderedQuantity(new BigDecimal(0));
				productsList.add(product);
			}
		} catch (IOException ioex) {
			System.err.println("Error reading the file!");
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Error closing the fileReader!");
				}
			}
		}
		return productsList;
	}

}

class Product {
	private String name;
	private BigDecimal price;
	private BigDecimal orderedQuantity;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getOrderedQuantity() {
		return orderedQuantity;
	}
	
	public void setOrderedQuantity(BigDecimal orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	
	public BigDecimal calcOrder() {
		BigDecimal sum = this.price.multiply(this.orderedQuantity);
		return sum;
	}
}
