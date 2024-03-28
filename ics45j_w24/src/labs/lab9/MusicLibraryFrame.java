package labs.lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class MusicLibraryFrame extends JFrame {
	private static final String STUDENT_NAME = "Ivan Leung";
	private static final int STUDENT_ID = 67485846;
	private static final int DEFAULT_FRAME_WIDTH = 960;
	private static final int DEFAULT_FRAME_HEIGHT = 720;

	int lastSelectedSongIndex;

	private JList<Song> songList;
	private DefaultListModel<Song> model;
	private JButton deleteButton;

	private JLabel totalRunningTimeLabel;
	private double totalRunningTime;

	private JLabel titleLabel;
	private JTextField titleTextField;

	private JLabel artistLabel;
	private JTextField artistTextField;

	private JLabel shareGroupLabel;
	private JCheckBox friendCheckBox;
	private JCheckBox familyCheckBox;
	private JCheckBox coworkerCheckBox;

	private JLabel categoryLabel;
	private JComboBox<String> categoryComboBox; // Drop down menu

	private JLabel runningTimeLabel;
	private JTextField runningTimeTextField;

	private JLabel notesLabel;
	private JTextArea notesTextArea;

	private JButton saveSongButton;
	private JButton newSongButton;

	MusicLibraryFrame() {
		setTitle(String.format("%s - %d", STUDENT_NAME, STUDENT_ID));
		setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
		lastSelectedSongIndex = -1;
		totalRunningTime = 0.0;
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(createLeftPanel());
		mainPanel.add(createRightPanel());
		add(mainPanel);
	}

	private JPanel createLeftPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout()); // Create a new layout
		panel.add(createSongList(), BorderLayout.CENTER);
		panel.add(createDeleteButtonPanel(), BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createRightPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(7, 1)); // row = 7, col = 1
		panel.add(titlePanel());
		panel.add(artistPanel());
		panel.add(shareGroupPanel());
		panel.add(categoryPanel());
		panel.add(runningTimePanel());
		panel.add(notesPanel());
		panel.add(songButtonPanel());

		return panel;
	}

	private JScrollPane createSongList() {
		class SelectionListener implements ListSelectionListener {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					lastSelectedSongIndex = songList.getSelectedIndex();
					
					if (lastSelectedSongIndex > -1) {
						Song selectedSong = model.getElementAt(lastSelectedSongIndex);

						songList.ensureIndexIsVisible(lastSelectedSongIndex);

						titleTextField.setText(selectedSong.getTitle());
						artistTextField.setText(selectedSong.getArtist());
						friendCheckBox.setSelected(selectedSong.getFriendGroup());
						familyCheckBox.setSelected(selectedSong.getFamilyGroup());
						coworkerCheckBox.setSelected(selectedSong.getCoworkerGroup());
						categoryComboBox.setSelectedItem(selectedSong.getCategroy());
						runningTimeTextField.setText(String.format("%.1f", selectedSong.getRunningTime()));
						notesTextArea.setText(selectedSong.getNotes());
					}
				}
			}
		}
		songList = new JList<Song>(); // Create new JList
		model = new DefaultListModel<>(); // Create new model for JList
		songList.setSelectionMode(1);
		songList.setVisible(true);
		songList.setBackground(Color.WHITE); // Set JList background color to white
		songList.setModel(model); // Set JList model
		songList.setAlignmentX(LEFT_ALIGNMENT); // Align texts in JList to the left
		songList.addListSelectionListener(new SelectionListener());

		JPanel songListPanel = new JPanel(new BorderLayout()); // Create a new JPanel for JList
		songListPanel.setVisible(true);
		songListPanel.add(songList); // Add JList to JPanel

		JScrollPane scrollPane = new JScrollPane(songListPanel); // Create a new JScrollPane for JList JPanel
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show scroll bar
		scrollPane.setPreferredSize(new Dimension(DEFAULT_FRAME_WIDTH / 2, DEFAULT_FRAME_HEIGHT - 100));
		return scrollPane;
	}

	private JPanel createDeleteButtonPanel() {
		class DeleteSongListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lastSelectedSongIndex > -1 && lastSelectedSongIndex < model.size()) {
					totalRunningTime -= model.get(lastSelectedSongIndex).getRunningTime();
					totalRunningTimeLabel.setText(String.format("Total running time: %.1f", totalRunningTime));
					model.remove(lastSelectedSongIndex);
					songList.clearSelection();
				}
			}
		}
		JPanel panel = new JPanel();

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new DeleteSongListener());
		totalRunningTimeLabel = new JLabel(String.format("Total running time: %.1f", totalRunningTime));

		panel.add(deleteButton);
		panel.add(totalRunningTimeLabel);

		return panel;
	}

	private JPanel titlePanel() {
		JPanel panel = new JPanel();
		titleLabel = new JLabel("Title:");
		titleTextField = new JTextField(25);

		titleTextField.setText("");
		panel.add(titleLabel);
		panel.add(titleTextField);
		return panel;
	}

	private JPanel artistPanel() {
		JPanel panel = new JPanel();
		artistLabel = new JLabel("Artist:");
		artistTextField = new JTextField(25);

		artistTextField.setText("");
		panel.add(artistLabel);
		panel.add(artistTextField);
		return panel;
	}

	private JPanel shareGroupPanel() {
		JPanel panel = new JPanel();
		shareGroupLabel = new JLabel("Share with:");
		friendCheckBox = new JCheckBox(Song.FRIEND_GROUP);
		familyCheckBox = new JCheckBox(Song.FAMILY_GROUP);
		coworkerCheckBox = new JCheckBox(Song.COWORKER_GROUP);
		
		panel.add(shareGroupLabel);
		panel.add(friendCheckBox);
		panel.add(familyCheckBox);
		panel.add(coworkerCheckBox);

		return panel;
	}

	private JPanel categoryPanel() {
		JPanel panel = new JPanel();
		categoryLabel = new JLabel("Category:");
		categoryComboBox = new JComboBox<String>();

		for (String name : Song.CATEGORIES) {
			categoryComboBox.addItem(name);
		}

		panel.add(categoryLabel);
		panel.add(categoryComboBox);
		return panel;
	}

	private JPanel runningTimePanel() {
		JPanel panel = new JPanel();
		runningTimeLabel = new JLabel("Running time:");
		runningTimeTextField = new JTextField(12);

		runningTimeTextField.setText("0.0");

		panel.add(runningTimeLabel);
		panel.add(runningTimeTextField);
		return panel;
	}

	private JPanel notesPanel() {
		JPanel panel = new JPanel();
		notesLabel = new JLabel("Notes");
		notesTextArea = new JTextArea(5, 25); // rows = 4, cols = 25
		JScrollPane scrollPane = new JScrollPane(notesTextArea);

		notesTextArea.setText("");
		notesTextArea.setLineWrap(true);
		panel.add(notesLabel);
		panel.add(scrollPane);
		return panel;
	}

	private JPanel songButtonPanel() {
		JPanel panel = new JPanel();

		panel.add(saveSongButtonPanel());
		panel.add(newSongButtonPanel());
		return panel;
	}

	// Save a new song or update an existing song
	private JPanel saveSongButtonPanel() {
		class SaveSongListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentSelectedSongIndex = -1;
				Song newSong = getNewSong();

				if (isNotValidSong(newSong)) {
					songList.clearSelection();
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.WARNING_MESSAGE);
					currentSelectedSongIndex = model.indexOf(newSong);
					if (currentSelectedSongIndex > -1) {
						songList.setSelectedIndex(currentSelectedSongIndex);
						songList.ensureIndexIsVisible(currentSelectedSongIndex);
					}
					return;
				}
				if (lastSelectedSongIndex < 0 && !model.contains(newSong)) {
					currentSelectedSongIndex = saveSong(newSong);
				} else {
					currentSelectedSongIndex = updateSong(newSong);
				}

				JOptionPane.showMessageDialog(null, "Song saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
				songList.setSelectedIndex(currentSelectedSongIndex);
				songList.ensureIndexIsVisible(currentSelectedSongIndex);
			}
			
			private boolean isNotValidSong(Song newSong) {
				return newSong == null || newSong.getRunningTime() < 0 ||
						newSong.getTitle().equals("") || newSong.getArtist().equals("") ||
						(lastSelectedSongIndex < 0 && model.contains(newSong)) ||
						(model.contains(newSong) && lastSelectedSongIndex != model.indexOf(newSong));
			}
		}
		JPanel panel = new JPanel();
		saveSongButton = new JButton("Save Song");
		ActionListener listener = new SaveSongListener();

		saveSongButton.addActionListener(listener);
		panel.add(saveSongButton);
		return panel;
	}
	
	// Create a new song from the text fields
	private Song getNewSong() {
		String title = titleTextField.getText();
		String artist = artistTextField.getText();
		String category = (String) categoryComboBox.getSelectedItem();
		double runningTime = 0.0;
		try {
			runningTime = Double.parseDouble(runningTimeTextField.getText());
		} catch(NumberFormatException e) {
			return null;
		}
		String notes = notesTextArea.getText();
		boolean[] checkedGroups = {friendCheckBox.isSelected(), familyCheckBox.isSelected(), coworkerCheckBox.isSelected()};
		Song newSong = new Song(title, artist, checkedGroups, category, runningTime, notes);
		
		return newSong;
	}

	// Save a song to JList
	private int saveSong(Song newSong) {
		totalRunningTime += newSong.getRunningTime();
		totalRunningTimeLabel.setText(String.format("Total running time: %.1f", totalRunningTime));

		model.addElement(newSong); // Add new song the list
		sortSongList();

		return model.indexOf(newSong);
	}

	private int updateSong(Song existingSong) {
		double runningTime = model.get(lastSelectedSongIndex).getRunningTime();
		totalRunningTime -= runningTime;
		totalRunningTime += existingSong.getRunningTime();
		totalRunningTimeLabel.setText(String.format("Total running time: %.1f", totalRunningTime));

		model.set(lastSelectedSongIndex, existingSong);
		sortSongList();
		
		return model.indexOf(existingSong);
	}
	
	private void sortSongList() {
		List<Song> oldList = Collections.list(model.elements());
		Collections.sort((oldList)); // Sort the list
		model.clear();
		for (Song song : oldList) { // Add all elements back to the list
			model.addElement(song);
		}
	}

	// Clear all text fields when new song button is clicked
	private JPanel newSongButtonPanel() {
		class NewSongListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAllFields();
			}
			
			private void clearAllFields() {
				titleTextField.setText("");
				artistTextField.setText("");
				friendCheckBox.setSelected(false);
				familyCheckBox.setSelected(false);
				coworkerCheckBox.setSelected(false);
				runningTimeTextField.setText("0.0");
				notesTextArea.setText("");
				songList.clearSelection();
			}
		}
		JPanel panel = new JPanel();
		newSongButton = new JButton("New Song");

		ActionListener listener = new NewSongListener();
		newSongButton.addActionListener(listener);

		panel.add(newSongButton);
		return panel;
	}
}
