package Models;


public abstract class MediaMaterial {

	abstract public String getId();
	abstract public String getName();
	abstract public String getOwnerName();
	abstract public String getImageUrl();

	@Override
	public String toString() {
		return "MediaMaterial{" +
				"Name:" + getName() +
				"Owner:" + getOwnerName() +
				"}";
	}
	@Override
	public boolean equals(Object obj) {
		final MediaMaterial mediaMaterial = (MediaMaterial) obj;
		return getId().equals(mediaMaterial.getId());
	}
}
