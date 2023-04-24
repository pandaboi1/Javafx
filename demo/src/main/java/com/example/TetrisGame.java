package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TetrisGame extends Tetris{
        // The variables
        public static final int MOVE = 25;
        public static final int SIZE = 25;
        public static int XMAX = 400;
        public static int YMAX = 800;
        public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];         // Grid mesh
        protected static Pane group = new Pane();
        public static HBox groupProperties = new HBox(group);
        protected static Form object;        
        public static Scene scene = new Scene(groupProperties, 600, 800);
	    public static int score = 0;
        static int top = 0;
        static boolean game = true;
        protected static Form nextObj = Controller.makeRect();
        static int linesNo = 0;
    
    public TetrisGame(Stage stage) {

        groupProperties.setStyle("-fx-background-color: #dbe9ff;");
        groupProperties.setAlignment(Pos.CENTER);
        Scene newScene = scene;
        
		stage.setTitle("Tetris - Game");
        stage.setScene(newScene);
		stage.show();


        for (int[] a : MESH) {
			Arrays.fill(a, 0);
		}

		Line line = new Line(XMAX, 0, XMAX, YMAX);
		Text scoretext = new Text("Score: ");
		scoretext.setStyle("-fx-font: 20 arial;");
		scoretext.setY(50);
		scoretext.setX(XMAX + 5);
		Text level = new Text("Lines: ");
		level.setStyle("-fx-font: 20 arial;");
		level.setY(100);
		level.setX(XMAX + 5);
		level.setFill(Color.GREEN);
        
		group.getChildren().addAll(scoretext, line, level);

		Form a = nextObj;
		group.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPress(a);
		object = a;
		nextObj = Controller.makeRect();
        
        
		Timer fall = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
								|| object.d.getY() == 0)
							top++;
						else
							top = 0;

						if (top == 2) {
							// GAME OVER
							Text over = new Text("GAME OVER");
							over.setFill(Color.RED);
							over.setStyle("-fx-font: 70 arial;");
							over.setY(250);
							over.setX(10);
							group.getChildren().add(over);
							game = false;
						}
						// Exit
						if (top == 15) {
							//System.exit(0);
						}

						if (game) {
							MoveDown(object);
							scoretext.setText("Score: " + Integer.toString(score));
							level.setText("Lines: " + Integer.toString(linesNo));
						}
					}
				});
			}
		};
		fall.schedule(task, 0, 300); 
        
        
       
	}
    
    private void moveOnKeyPress(Form form) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case RIGHT:
					Controller.MoveRight(form);
					break;
				case DOWN:
					MoveDown(form);
					score++;
					break;
				case LEFT:
					Controller.MoveLeft(form);
					break;
				case UP:
					MoveTurn(form);
					break;
                    case A:
                        break;
                    case ACCEPT:
                        break;
                    case ADD:
                        break;
                    case AGAIN:
                        break;
                    case ALL_CANDIDATES:
                        break;
                    case ALPHANUMERIC:
                        break;
                    case ALT:
                        break;
                    case ALT_GRAPH:
                        break;
                    case AMPERSAND:
                        break;
                    case ASTERISK:
                        break;
                    case AT:
                        break;
                    case B:
                        break;
                    case BACK_QUOTE:
                        break;
                    case BACK_SLASH:
                        break;
                    case BACK_SPACE:
                        break;
                    case BEGIN:
                        break;
                    case BRACELEFT:
                        break;
                    case BRACERIGHT:
                        break;
                    case C:
                        break;
                    case CANCEL:
                        break;
                    case CAPS:
                        break;
                    case CHANNEL_DOWN:
                        break;
                    case CHANNEL_UP:
                        break;
                    case CIRCUMFLEX:
                        break;
                    case CLEAR:
                        break;
                    case CLOSE_BRACKET:
                        break;
                    case CODE_INPUT:
                        break;
                    case COLON:
                        break;
                    case COLORED_KEY_0:
                        break;
                    case COLORED_KEY_1:
                        break;
                    case COLORED_KEY_2:
                        break;
                    case COLORED_KEY_3:
                        break;
                    case COMMA:
                        break;
                    case COMMAND:
                        break;
                    case COMPOSE:
                        break;
                    case CONTEXT_MENU:
                        break;
                    case CONTROL:
                        break;
                    case CONVERT:
                        break;
                    case COPY:
                        break;
                    case CUT:
                        break;
                    case D:
                        break;
                    case DEAD_ABOVEDOT:
                        break;
                    case DEAD_ABOVERING:
                        break;
                    case DEAD_ACUTE:
                        break;
                    case DEAD_BREVE:
                        break;
                    case DEAD_CARON:
                        break;
                    case DEAD_CEDILLA:
                        break;
                    case DEAD_CIRCUMFLEX:
                        break;
                    case DEAD_DIAERESIS:
                        break;
                    case DEAD_DOUBLEACUTE:
                        break;
                    case DEAD_GRAVE:
                        break;
                    case DEAD_IOTA:
                        break;
                    case DEAD_MACRON:
                        break;
                    case DEAD_OGONEK:
                        break;
                    case DEAD_SEMIVOICED_SOUND:
                        break;
                    case DEAD_TILDE:
                        break;
                    case DEAD_VOICED_SOUND:
                        break;
                    case DECIMAL:
                        break;
                    case DELETE:
                        break;
                    case DIGIT0:
                        break;
                    case DIGIT1:
                        break;
                    case DIGIT2:
                        break;
                    case DIGIT3:
                        break;
                    case DIGIT4:
                        break;
                    case DIGIT5:
                        break;
                    case DIGIT6:
                        break;
                    case DIGIT7:
                        break;
                    case DIGIT8:
                        break;
                    case DIGIT9:
                        break;
                    case DIVIDE:
                        break;
                    case DOLLAR:
                        break;
                    case E:
                        break;
                    case EJECT_TOGGLE:
                        break;
                    case END:
                        break;
                    case ENTER:
                        break;
                    case EQUALS:
                        break;
                    case ESCAPE:
                        break;
                    case EURO_SIGN:
                        break;
                    case EXCLAMATION_MARK:
                        break;
                    case F:
                        break;
                    case F1:
                        break;
                    case F10:
                        break;
                    case F11:
                        break;
                    case F12:
                        break;
                    case F13:
                        break;
                    case F14:
                        break;
                    case F15:
                        break;
                    case F16:
                        break;
                    case F17:
                        break;
                    case F18:
                        break;
                    case F19:
                        break;
                    case F2:
                        break;
                    case F20:
                        break;
                    case F21:
                        break;
                    case F22:
                        break;
                    case F23:
                        break;
                    case F24:
                        break;
                    case F3:
                        break;
                    case F4:
                        break;
                    case F5:
                        break;
                    case F6:
                        break;
                    case F7:
                        break;
                    case F8:
                        break;
                    case F9:
                        break;
                    case FAST_FWD:
                        break;
                    case FINAL:
                        break;
                    case FIND:
                        break;
                    case FULL_WIDTH:
                        break;
                    case G:
                        break;
                    case GAME_A:
                        break;
                    case GAME_B:
                        break;
                    case GAME_C:
                        break;
                    case GAME_D:
                        break;
                    case GREATER:
                        break;
                    case H:
                        break;
                    case HALF_WIDTH:
                        break;
                    case HELP:
                        break;
                    case HIRAGANA:
                        break;
                    case HOME:
                        break;
                    case I:
                        break;
                    case INFO:
                        break;
                    case INPUT_METHOD_ON_OFF:
                        break;
                    case INSERT:
                        break;
                    case INVERTED_EXCLAMATION_MARK:
                        break;
                    case J:
                        break;
                    case JAPANESE_HIRAGANA:
                        break;
                    case JAPANESE_KATAKANA:
                        break;
                    case JAPANESE_ROMAN:
                        break;
                    case K:
                        break;
                    case KANA:
                        break;
                    case KANA_LOCK:
                        break;
                    case KANJI:
                        break;
                    case KATAKANA:
                        break;
                    case KP_DOWN:
                        break;
                    case KP_LEFT:
                        break;
                    case KP_RIGHT:
                        break;
                    case KP_UP:
                        break;
                    case L:
                        break;
                    case LEFT_PARENTHESIS:
                        break;
                    case LESS:
                        break;
                    case M:
                        break;
                    case META:
                        break;
                    case MINUS:
                        break;
                    case MODECHANGE:
                        break;
                    case MULTIPLY:
                        break;
                    case MUTE:
                        break;
                    case N:
                        break;
                    case NONCONVERT:
                        break;
                    case NUMBER_SIGN:
                        break;
                    case NUMPAD0:
                        break;
                    case NUMPAD1:
                        break;
                    case NUMPAD2:
                        break;
                    case NUMPAD3:
                        break;
                    case NUMPAD4:
                        break;
                    case NUMPAD5:
                        break;
                    case NUMPAD6:
                        break;
                    case NUMPAD7:
                        break;
                    case NUMPAD8:
                        break;
                    case NUMPAD9:
                        break;
                    case NUM_LOCK:
                        break;
                    case O:
                        break;
                    case OPEN_BRACKET:
                        break;
                    case P:
                        break;
                    case PAGE_DOWN:
                        break;
                    case PAGE_UP:
                        break;
                    case PASTE:
                        break;
                    case PAUSE:
                        break;
                    case PERIOD:
                        break;
                    case PLAY:
                        break;
                    case PLUS:
                        break;
                    case POUND:
                        break;
                    case POWER:
                        break;
                    case PREVIOUS_CANDIDATE:
                        break;
                    case PRINTSCREEN:
                        break;
                    case PROPS:
                        break;
                    case Q:
                        break;
                    case QUOTE:
                        break;
                    case QUOTEDBL:
                        break;
                    case R:
                        break;
                    case RECORD:
                        break;
                    case REWIND:
                        break;
                    case RIGHT_PARENTHESIS:
                        break;
                    case ROMAN_CHARACTERS:
                        break;
                    case S:
                        break;
                    case SCROLL_LOCK:
                        break;
                    case SEMICOLON:
                        break;
                    case SEPARATOR:
                        break;
                    case SHIFT:
                        break;
                    case SHORTCUT:
                        break;
                    case SLASH:
                        break;
                    case SOFTKEY_0:
                        break;
                    case SOFTKEY_1:
                        break;
                    case SOFTKEY_2:
                        break;
                    case SOFTKEY_3:
                        break;
                    case SOFTKEY_4:
                        break;
                    case SOFTKEY_5:
                        break;
                    case SOFTKEY_6:
                        break;
                    case SOFTKEY_7:
                        break;
                    case SOFTKEY_8:
                        break;
                    case SOFTKEY_9:
                        break;
                    case SPACE:
                        break;
                    case STAR:
                        break;
                    case STOP:
                        break;
                    case SUBTRACT:
                        break;
                    case T:
                        break;
                    case TAB:
                        break;
                    case TRACK_NEXT:
                        break;
                    case TRACK_PREV:
                        break;
                    case U:
                        break;
                    case UNDEFINED:
                        break;
                    case UNDERSCORE:
                        break;
                    case UNDO:
                        break;
                    case V:
                        break;
                    case VOLUME_DOWN:
                        break;
                    case VOLUME_UP:
                        break;
                    case W:
                        break;
                    case WINDOWS:
                        break;
                    case X:
                        break;
                    case Y:
                        break;
                    case Z:
                        break;
                    default:
                        break;
				}
			}
		});
	}

	private void MoveTurn(Form form) {
		int f = form.form;
		Rectangle a = form.a;
		Rectangle b = form.b;
		Rectangle c = form.c;
		Rectangle d = form.d;
		switch (form.getName()) {
		case "j":
			if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveDown(form.c);
				MoveLeft(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveUp(form.c);
				MoveRight(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			break;
		case "l":
			if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveUp(form.c);
				MoveRight(form.c);
				MoveUp(form.b);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveRight(form.b);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveRight(form.b);
				MoveRight(form.b);
				MoveDown(form.b);
				MoveDown(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveDown(form.c);
				MoveLeft(form.c);
				MoveDown(form.b);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveLeft(form.b);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveLeft(form.b);
				MoveLeft(form.b);
				MoveUp(form.b);
				MoveUp(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				form.changeForm();
				break;
			}
			break;
		case "o":
			break;
		case "s":
			if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			break;
		case "t":
			if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveDown(form.d);
				MoveLeft(form.d);
				MoveLeft(form.c);
				MoveUp(form.c);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveLeft(form.d);
				MoveUp(form.d);
				MoveUp(form.c);
				MoveRight(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveUp(form.d);
				MoveRight(form.d);
				MoveRight(form.c);
				MoveDown(form.c);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveRight(form.d);
				MoveDown(form.d);
				MoveDown(form.c);
				MoveLeft(form.c);
				form.changeForm();
				break;
			}
			break;
		case "z":
			if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				MoveUp(form.b);
				MoveRight(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				MoveUp(form.b);
				MoveRight(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			break;
		case "i":
			if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				MoveUp(form.a);
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.a);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveDown(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				MoveDown(form.a);
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.a);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveUp(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				MoveUp(form.a);
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.a);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveDown(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				MoveDown(form.a);
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.a);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveUp(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			break;
		}
	}

	private void RemoveRows(Pane pane) {
		ArrayList<Node> rects = new ArrayList<Node>();
		ArrayList<Integer> lines = new ArrayList<Integer>();
		ArrayList<Node> newrects = new ArrayList<Node>();
		int full = 0;
		for (int i = 0; i < MESH[0].length; i++) {
			for (int j = 0; j < MESH.length; j++) {
				if (MESH[j][i] == 1)
					full++;
			}
			if (full == MESH.length)
			lines.add(i);
			//lines.add(i + lines.size());
			full = 0;
		}
		if (lines.size() > 0)
			do {
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				score += 50;
				linesNo++;

				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() == lines.get(0) * SIZE) {
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						pane.getChildren().remove(node);
					} else
						newrects.add(node);
				}

				for (Node node : newrects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() < lines.get(0) * SIZE) {
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						a.setY(a.getY() + SIZE);
					}
				}
				lines.remove(0);
				rects.clear();
				newrects.clear();
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					try {
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				rects.clear();
			} while (lines.size() > 0);
	}

	private void MoveDown(Rectangle rect) {
		if (rect.getY() + MOVE < YMAX)
			rect.setY(rect.getY() + MOVE);

	}

	private void MoveRight(Rectangle rect) {
		if (rect.getX() + MOVE <= XMAX - SIZE)
			rect.setX(rect.getX() + MOVE);
	}

	private void MoveLeft(Rectangle rect) {
		if (rect.getX() - MOVE >= 0)
			rect.setX(rect.getX() - MOVE);
	}

	private void MoveUp(Rectangle rect) {
		if (rect.getY() - MOVE > 0)
			rect.setY(rect.getY() - MOVE);
	}

	private void MoveDown(Form form) {
		if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
				|| form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
			MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
			MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
			MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
			MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
			RemoveRows(group);

			Form a = nextObj;
			nextObj = Controller.makeRect();
			object = a;
			group.getChildren().addAll(a.a, a.b, a.c, a.d);
			moveOnKeyPress(a);
		}

		if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
				&& form.d.getY() + MOVE < YMAX) {
			int movea = MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
			int moveb = MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
			int movec = MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
			int moved = MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
			if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setY(form.a.getY() + MOVE);
				form.b.setY(form.b.getY() + MOVE);
				form.c.setY(form.c.getY() + MOVE);
				form.d.setY(form.d.getY() + MOVE);
			}
		}
	}

	private boolean moveA(Form form) {
		return (MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
	}

	private boolean moveB(Form form) {
		return (MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
	}

	private boolean moveC(Form form) {
		return (MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
	}

	private boolean moveD(Form form) {
		return (MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
	}

	private boolean cB(Rectangle rect, int x, int y) {
		boolean xb = false;
		boolean yb = false;
		if (x >= 0)
			xb = rect.getX() + x * MOVE <= XMAX - SIZE;
		if (x < 0)
			xb = rect.getX() + x * MOVE >= 0;
		if (y >= 0)
			yb = rect.getY() - y * MOVE > 0;
		if (y < 0)
			yb = rect.getY() + y * MOVE < YMAX;
		return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }
    
        /*
        Label score = new Label("Score");
        Label next = new Label("Next");
        Button menu = new Button("menu");

        menu.setStyle("-fx-background-color: grey; -fx-text-fill: white; -fx-font-size: 24px;"); 

        HBox line1 = new HBox(score);
        line1.setAlignment(Pos.CENTER_RIGHT);
        line1.setPadding(new Insets(20));

        HBox line2 = new HBox(next);
        line2.setAlignment(Pos.CENTER_RIGHT);
        line2.setPadding(new Insets(20));

        HBox line3 = new HBox(menu);
        line3.setAlignment(Pos.CENTER_RIGHT);
        line3.setPadding(new Insets(20));

         


        VBox left = new VBox();
        left.setPadding(new Insets(20)); 
        left.setStyle("-fx-font: 24 arial;");


        VBox right = new VBox(line1, line2, line3);
        right.setAlignment(Pos.TOP_RIGHT);
        right.setPadding(new Insets(20)); 
        right.setStyle("-fx-font: 24 arial;");
        HBox mainStage = new HBox(left, right);
        mainStage.setStyle("-fx-background-color: #dbe9ff;");
        Scene currentScene = new Scene(mainStage, 600, 800);                                 
        newStage.setScene(currentScene);
        newStage.show();

        */
    
} 
