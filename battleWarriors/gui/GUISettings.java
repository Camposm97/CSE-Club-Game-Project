package gui;

import javafx.scene.text.Font;

/**
 * Note: Wow, I like this.  I never thought of this before :O
 * Good idea for class! :D
 * @author Camposm97
 */
public class GUISettings {
	int width;
	int height;
	Font font; 
	
	public GUISettings (int width, int height, int fontSize){
		this.width = width;
		this.height = height;
		this.font = new Font(fontSize);
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
}
