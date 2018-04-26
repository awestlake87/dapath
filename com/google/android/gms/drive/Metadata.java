package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T mo2544a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) mo2544a(iq.JU);
    }

    public int getContentAvailability() {
        Integer num = (Integer) mo2544a(iu.KC);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) mo2544a(is.Kw);
    }

    public String getDescription() {
        return (String) mo2544a(iq.JW);
    }

    public DriveId getDriveId() {
        return (DriveId) mo2544a(iq.JT);
    }

    public String getEmbedLink() {
        return (String) mo2544a(iq.JX);
    }

    public String getFileExtension() {
        return (String) mo2544a(iq.JY);
    }

    public long getFileSize() {
        return ((Long) mo2544a(iq.JZ)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) mo2544a(is.Kx);
    }

    public String getMimeType() {
        return (String) mo2544a(iq.Kk);
    }

    public Date getModifiedByMeDate() {
        return (Date) mo2544a(is.Kz);
    }

    public Date getModifiedDate() {
        return (Date) mo2544a(is.Ky);
    }

    public String getOriginalFilename() {
        return (String) mo2544a(iq.Kl);
    }

    public long getQuotaBytesUsed() {
        return ((Long) mo2544a(iq.Ko)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) mo2544a(is.KA);
    }

    public String getTitle() {
        return (String) mo2544a(iq.Kr);
    }

    public String getWebContentLink() {
        return (String) mo2544a(iq.Kt);
    }

    public String getWebViewLink() {
        return (String) mo2544a(iq.Ku);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) mo2544a(iq.Ke);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) mo2544a(iq.Kc);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) mo2544a(iu.KD);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) mo2544a(iq.Kf);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) mo2544a(iq.Kg);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) mo2544a(iq.Kh);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) mo2544a(iq.Kp);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) mo2544a(iq.Ks);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) mo2544a(iq.Kj);
        return bool == null ? false : bool.booleanValue();
    }
}
