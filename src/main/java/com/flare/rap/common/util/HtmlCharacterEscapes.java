package com.flare.rap.common.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.LookupTranslator;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public class HtmlCharacterEscapes extends CharacterEscapes {

    private final int[] asciiEscapes;
    private final CharSequenceTranslator translator;

    public HtmlCharacterEscapes() {

        Map<CharSequence, CharSequence> CUSTOM_ESCAPE = Map.of("(", "&#40;", ")", "&#41", "#", "&#35;", "\'", "&#39;");

        //XSS 방지 처리할 특수 문자 지정
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['('] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes[')'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['#'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;

        // XSS 방지 처리 특수 문자 인코딩 값 지정 -- 불필요 코드
        translator = new AggregateTranslator(
                new LookupTranslator(EntityArrays.BASIC_ESCAPE),
                new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE),
                new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE),
                new LookupTranslator(CUSTOM_ESCAPE)
        );
    }

    @Override
    public int[] getEscapeCodesForAscii() { return this.asciiEscapes; }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        //Escape 처리
        //return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString((char) ch)));
        //참고 - 커스터마이징이 필요없다면 아래와 같이 Apache Commons Lang3에서 제공하는 메서드를 써도 된다.
        return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString((char) ch)));
    }
}
