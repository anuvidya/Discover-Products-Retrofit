package com.example.retrofitproductslist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsItem implements Parcelable {

	@SerializedName("discountPercentage")
	private Object discountPercentage;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("price")
	private String price;

	@SerializedName("rating")
	private Object rating;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("stock")
	private int stock;

	@SerializedName("category")
	private String category;

	@SerializedName("brand")
	private String brand;

	protected ProductsItem(Parcel in) {
		thumbnail = in.readString();
		images = in.createStringArrayList();
		price = String.valueOf(in.readInt());
		description = in.readString();
		id = in.readString();
		title = in.readString();
		stock = in.readInt();
		category = in.readString();
		brand = in.readString();
	}

	public static final Creator<ProductsItem> CREATOR = new Creator<ProductsItem>() {
		@Override
		public ProductsItem createFromParcel(Parcel in) {
			return new ProductsItem(in);
		}

		@Override
		public ProductsItem[] newArray(int size) {
			return new ProductsItem[size];
		}
	};

	public void setDiscountPercentage(Object discountPercentage){
		this.discountPercentage = discountPercentage;
	}

	public Object getDiscountPercentage(){
		return discountPercentage;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setPrice(int price){
		this.price = String.valueOf(price);
	}

	public String getPrice(){
		return price;
	}

	public void setRating(Object rating){
		this.rating = rating;
	}

	public Object getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getStock(){
		return stock;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel parcel, int i) {
		parcel.writeString(thumbnail);
		parcel.writeStringList(images);
		parcel.writeInt(Integer.parseInt(price));
		parcel.writeString(description);
		parcel.writeString(id);
		parcel.writeString(title);
		parcel.writeInt(stock);
		parcel.writeString(category);
		parcel.writeString(brand);
	}
}