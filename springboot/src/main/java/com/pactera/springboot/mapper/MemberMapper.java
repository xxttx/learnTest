package com.pactera.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pactera.springboot.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
