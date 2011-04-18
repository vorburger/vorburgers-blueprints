package ch.vorburger.uftam.model.representation;

public class DataListRequest<T> {

	// TODO REST GET with this as parameter.
	// TODO How to make default parameters?

	private int howMany;
	private long first;

	public DataListRequest(long first, int howMany) {
		this.first = first;
		this.howMany = howMany;
	}

	long getFirst() {
		return first;
	}

	int getHowMany() {
		return howMany;
	}

	// TODO sorting! @see org.springframework.data.domain.Sort &
	// org.springframework.data.domain.Sort.Order

	// TODO have a look at org.springframework.data.domain.Pageable &
	// org.springframework.data.domain.Page

	// TODO query Filtering!

	// TODO restricting/trimming resource details (e.g. for a column chooser to reduce amount of
	// data)

}
