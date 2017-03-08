package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.usuario.Usuario;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface BannerListener {

    void loadBanners(final List<Banner> banners);
}
