package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

@SuppressWarnings({ "static-access", "unused" })

public class Deck {
	private eSuit eSuit;
	private eRank eRank;
	

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();



	
	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	
	public void getRemaining(Object eNum) {
	int cardCounter1 = 0;
	int cardCounter2 = 0;

	
	if (eNum instanceof eSuit) {
		this.eSuit = (eSuit) eSuit;
		
	for (Card c : cardsInDeck) {
		if (c.geteSuit() == eNum)
			cardCounter1++;
	}
	
	if (eNum instanceof eRank) {
		this.eRank = (eRank) eRank;
	for (Card c : cardsInDeck) {
		if (c.geteRank() == eNum)
			cardCounter2++;
	}
	}
	}
	}
}

