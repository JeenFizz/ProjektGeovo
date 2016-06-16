package contract;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

class NettleMeeting extends JDialog {
	private static final long	serialVersionUID	= 8247082990127296497L;
	private final JPanel			contentPanel			= new JPanel();

	public NettleMeeting() {
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Nettle meeting");
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setLayout(new FlowLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		{
			final JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				this.getRootPane().setDefaultButton(okButton);
			}
			{
				final JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
