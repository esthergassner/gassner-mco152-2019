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
    private final JLabel picLabel;
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
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        picLabel = new JLabel();
        photo = list.get(photoNumber);
        picLabel.setIcon(new ImageIcon(new URL(photo.getUrl())));

        numLabel = new JLabel("#" + (photoNumber + 1));
        JButton prev = new JButton("PREV");
        prev.addActionListener(e -> {
            if (photoNumber > 0) {
                photoNumber--;
                setPhoto();
                updatePhotoNumber();
            }
        });
        JButton next = new JButton("NEXT");
        next.addActionListener(e -> {
            photoNumber++;
            setPhoto();
            updatePhotoNumber();
        });

        JPanel controlPanel = new JPanel();

        controlPanel.add(prev);
        controlPanel.add(numLabel);
        controlPanel.add(next);

        root.add(picLabel, BorderLayout.CENTER);
        root.add(controlPanel, BorderLayout.SOUTH);

        setContentPane(root);
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
