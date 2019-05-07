package gassner.net;

import io.reactivex.disposables.Disposable;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoAlbumFrame extends JFrame
{
    private int photoNumber;
    private final JLabel numLabel;
    private JLabel picLabel;
    private JList<String> titleList;
    private PhotoList list;
    private Photo photo;

    public PhotoAlbumFrame() throws MalformedURLException
    {
        JsonPlaceholderClient client = new JsonPlaceholderClient();
        Disposable disposable = client.getPhotoList()
                .subscribe(photoList -> {
                        System.out.println(photoList);
                        list = photoList;
                    }
                );

        setTitle("Photo Album");
        setSize(2000, 1500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JScrollPane listScrollPane = setUpScrollPane();
        setUpPicLabel();
        JButton prev = setupPrev();
        JButton next = setupNext();
        numLabel = new JLabel("#" + (photoNumber + 1));

        JPanel controlPanel = new JPanel();

        controlPanel.add(prev);
        controlPanel.add(numLabel);
        controlPanel.add(next);
        root.add(picLabel, BorderLayout.CENTER);
        root.add(listScrollPane, BorderLayout.EAST);
        root.add(controlPanel, BorderLayout.SOUTH);

        setContentPane(root);

    }

    private void setUpPicLabel() throws MalformedURLException
    {
        picLabel = new JLabel();
        photo = list.get(photoNumber);
        picLabel.setIcon(new ImageIcon(new URL(photo.getUrl())));
    }

    private JScrollPane setUpScrollPane()
    {
        titleList = new JList<>();
        String[] titles = new String[list.size()];
        for (int ix = 0; ix < list.size(); ix++) {
            titles[ix] = list.get(ix).getTitle();
        }
        titleList.setListData(titles);
        titleList.addListSelectionListener(e -> {
            photoNumber = titleList.getSelectedIndex();
            setPhoto();
            updatePhotoNumber();
        });
        JScrollPane scrollPane = new JScrollPane(titleList);
        return scrollPane;
    }

    private JButton setupNext()
    {
        JButton next = new JButton("NEXT");
        next.addActionListener(e -> {
            photoNumber++;
            setPhoto();
            updatePhotoNumber();
        });
        return next;
    }

    private JButton setupPrev()
    {
        JButton prev = new JButton("PREV");
        prev.addActionListener(e -> {
            if (photoNumber > 0) {
                photoNumber--;
                setPhoto();
                updatePhotoNumber();
            }
        });
        return prev;
    }

    private void setPhoto()
    {
        photo = list.get(photoNumber);
        try {
            picLabel.setIcon(new ImageIcon(new URL(photo.getUrl())));
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }

    private void updatePhotoNumber()
    {
        numLabel.setText("#" + (photoNumber + 1));
    }

    public static void main(String[] args)
    {
        PhotoAlbumFrame frame = null;
        try
        {
            frame = new PhotoAlbumFrame();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }
}
