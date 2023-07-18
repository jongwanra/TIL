package chapter21;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkCastingDTO();
    }

    private void checkCastingDTO() {

        CastingDTO<String> dto1 = new CastingDTO<String>();
        dto1.setObject(new String());

        CastingDTO<StringBuffer> dto2 = new CastingDTO<StringBuffer>();
        dto2.setObject(new StringBuffer());

        CastingDTO<StringBuilder> dto3 = new CastingDTO<StringBuilder>();
        dto3.setObject(new StringBuilder());

        String object1 = dto1.getObject();
        StringBuffer object2 = dto2.getObject();
        StringBuilder object3 = dto3.getObject();
    }
}
