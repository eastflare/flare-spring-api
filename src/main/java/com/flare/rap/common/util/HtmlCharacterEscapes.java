package com.flare.rap.common.util;

import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.LookupTranslator;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;

public class HtmlCharacterEscapes extends CharacterEscapes {
    private final int[] asciiEscapes;
    private final CharSequenceTranslator translator;

    public HtmlCharacterEscapes() {

        /**
         * 여기에서 커스터마이징 가능
         * 이전의 Apache Commons Lang3는 LookupTranslator의 파라미터로
         * String[][]을 전달하였으나, 새로운 Apache Commons Text는 파라미터로
         * Map<CharSequence, CharSequence>를 전달해야 한다.
         * !! 현재는 사용하지 않습니다.
         * */
        Map<CharSequence, CharSequence> CUSTOM_ESCAPE = Map.of("(", "&#40;", ")", "&#41;", "#", "&#35;", "\'", "&#39;");

        //XSS 방지 처리할 특수 문자 지정
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
        //asciiEscapes['&'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['('] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes[')'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['#'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;

        // 2. XSS 방지 처리 특수 문자 인코딩 값 지정  -- 불필요 코드
        translator = new AggregateTranslator(
                new LookupTranslator(EntityArrays.BASIC_ESCAPE),  // <, >, &, " 는 여기에 포함됨
                new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE),
                new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE),
                new LookupTranslator(CUSTOM_ESCAPE)
        );

    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        //Escape 처리
        // return new SerializedString(translator.translate(Character.toString((char) ch)));
        // 참고 - 커스터마이징이 필요없다면 아래와 같이 Apache Commons Lang3에서 제공하는 메서드를 써도 된다.
        return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString((char) ch)));
    }
}