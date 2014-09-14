import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class _09_List_of_Products {

	public static void main(String[] args) {
		ArrayList<Products> productList = new ArrayList<Products>();
		productList = readProductsFromFile(productList);
		Collections.sort(productList);
		writeSortedProductsToFile(productList);
				
	}

	private static void writeSortedProductsToFile(ArrayList<Products> productList) {
		BufferedWriter fileWriter = null;
		
		try {
			File newFile = new File("src/09_output.txt");
			newFile.createNewFile();
			fileWriter = new BufferedWriter(new FileWriter("src/09_output.txt"));
			for (Products product : productList) {
				String productToWrite = product.getPrice() + " " + product.getName();
				fileWriter.write(productToWrite);
				fileWriter.newLine();
			}
		} catch (IOException ioex) {
			System.err.println("Cannot write the file!");
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				System.err.println("Error closing fileWriter!");
			}
		}
		
	}

	public static ArrayList<Products> readProductsFromFile(ArrayList<Products> productList) {
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader("src/09_input.txt"));
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				String[] productInfo = line.split(" ");
				Products product = new Products();
				product.setName(productInfo[0]);
				product.setPrice(new BigDecimal(productInfo[1]));
				productList.add(product);
			}
		} catch (IOException ioex) {
			System.err.println("Error reading the file!");
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Error closing fileReader!");;
				}
			}
		}
		return productList;
	}

}

class Products implements Comparable<Products> {
	private String name;
	private BigDecimal price;

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
	
	@Override
    public int compareTo(Products compareProducts) {
        BigDecimal comparePrice=((Products)compareProducts).getPrice();
        return this.price.compareTo(comparePrice);
    }
}