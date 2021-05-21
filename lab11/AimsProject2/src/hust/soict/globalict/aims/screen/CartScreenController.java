package hust.soict.globalict.aims.screen;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {

	private Cart cart = CartScreenFx.cart;
	
	
	@FXML
	private TableView<Media>tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCate;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML
    private RadioButton rbTitle;
	

    @FXML
    private RadioButton rbID;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;
    
    @FXML 
    private Label totalCost;
	
    @FXML
    private Button placeOrder;
    
    @FXML
    private MenuItem viewStore;
    
    @FXML
    private Label play;
    
    @FXML
    void viewStore() {
    	Store tmp = StoreScreen.store;
    
    	new StoreScreen(tmp);
    }
	@FXML
	void btnRemovePressed(ActionEvent e) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
//		Cart tmp = cart;
//		new CartScreenFx(tmp);	
	}
	
//	void btnPlayPressed(ActionEvent e) {
//		Media item = tblMedia.getSelectionModel().getSelectedItem();
//	
//		play.setText("Playing "+ item.getTitle());
// 
//        play.setVisible(true);
//	}
//	
	public CartScreenController(Cart c) {
		super();
		this.cart = c;		
	}
	
	@FXML
	void placeOrder() {

		String message;
		message="The order is created.\nTotal cost: "+cart.totalCost()+" $\n";
		JOptionPane.showMessageDialog(null,
		message,"Ordered Successfully",JOptionPane.INFORMATION_MESSAGE);
		cart=new Cart();
		tblMedia.setItems(cart.getItemsInCart());
		
	}
	
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
		colMediaCate.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
		tblMedia.setItems(this.cart.getItemsInCart());
		String cost = cart.totalCost()+" $";
		totalCost.setText(cost);
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue!= null) {
							updateButtonBar(newValue);
						}
					}
				});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
		
		
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) btnPlay.setVisible(true);
		else btnPlay.setVisible(false);
	
	}
	void showFilteredMedia(String newValue){
		ObservableList<Media> tmp = FXCollections.observableArrayList();
		if (rbTitle.isSelected()){
			for (Media m : cart.getItemsInCart()) {
				if (m.getTitle().toLowerCase().contains(newValue.toLowerCase())) {
					tmp.add(m);
				}
			}
			tblMedia.setItems(tmp);
		}
		else {
				for (Media m : cart.getItemsInCart()) {
			
				if ((String.valueOf(m.getId())).toString().toLowerCase().contains(newValue.toLowerCase())) {
					tmp.add(m);
				}
			}
			tblMedia.setItems(tmp);
		}
	}
	
	
}
