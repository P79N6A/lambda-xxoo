package com.yatop.lambda.portal.web.controller;

import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.PortalConstant;
import com.yatop.lambda.portal.common.domain.PortalResponse;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.common.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Slf4j
@Validated
@RestController
@RequestMapping("movie")
public class MovieController extends BaseController {

    private String message;

    @GetMapping("hot")
    public PortalResponse getMoiveHot() throws PortalException {
        try {
            String data = HttpUtil.sendSSLPost(PortalConstant.TIME_MOVIE_HOT_URL, "locationId=328");
            return new PortalResponse().data(data);
        } catch (Exception e) {
            message = "获取热映影片信息失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @GetMapping("coming")
    public PortalResponse getMovieComing() throws PortalException {
        try {
            String data = HttpUtil.sendSSLPost(PortalConstant.TIME_MOVIE_COMING_URL, "locationId=328");
            return new PortalResponse().data(data);
        } catch (Exception e) {
            message = "获取即将上映影片信息失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @GetMapping("detail")
    public PortalResponse getDetail(@NotBlank(message = "{required}") String id) throws PortalException {
        try {
            String data = HttpUtil.sendSSLPost(PortalConstant.TIME_MOVIE_DETAIL_URL, "locationId=328&movieId=" + id);
            return new PortalResponse().data(data);
        } catch (Exception e) {
            message = "获取影片详情失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @GetMapping("comments")
    public PortalResponse getComments(@NotBlank(message = "{required}") String id) throws PortalException {
        try {
            String data = HttpUtil.sendSSLPost(PortalConstant.TIME_MOVIE_COMMENTS_URL, "movieId=" + id);
            return new PortalResponse().data(data);
        } catch (Exception e) {
            message = "获取影片评论失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
