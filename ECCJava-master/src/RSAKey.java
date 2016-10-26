package src;

//package ecc.rsa;

//import ecc.Key;
//import ecc.Rand;
import java.math.BigInteger;
import java.io.*;

public class RSAKey implements Key {
    public BigInteger n;
    protected BigInteger phin;
    protected BigInteger p;
    protected BigInteger q;
    protected BigInteger e;
    protected BigInteger d;
    protected boolean secret;

    public boolean isPublic() {
	return (!secret);
    }

    public RSAKey(int bits) {
	secret=true;
	p = new BigInteger(bits/2, 500, Rand.om);
	q = new BigInteger(bits/2, 500, Rand.om);
	n = p.multiply(q);
	phin = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	e = new BigInteger(bits, Rand.om);
	while(!e.gcd(phin).equals(BigInteger.ONE)) {
	    e = new BigInteger(bits, Rand.om);
	}
	d = e.modInverse(phin);
    }
    
    private RSAKey() {}

    /** setkey takes a key string generated by tostring and sets this key to its parameters*/
    public void setkey(String keystr) {
	return;
    }

    /** Turns this key into a public key (does nothing if this key is public) */
    public Key getPublic() {
	Key temp = new RSAKey();
	((RSAKey)temp).n = n;
	((RSAKey)temp).e = e;
	((RSAKey)temp).secret=false;
	return temp;
    }

    public void writeKey(OutputStream out) throws IOException {
	DataOutputStream output = new DataOutputStream(out);
	output.writeBoolean(secret);
	if(secret) {
	    System.out.println("Writing Secret key");
	    byte[] pb = p.toByteArray();
	    output.writeInt(pb.length);
	    output.write(pb);
	    byte[] qb = q.toByteArray();
	    output.writeInt(qb.length);
	    output.write(qb);
	    byte[] db = d.toByteArray();
	    output.writeInt(db.length);
	    output.write(db);
	} else {
	    System.out.println("Writing Public key");
	    byte[] nb = n.toByteArray();
	    output.writeInt(nb.length);
	    output.write(nb);
	}
	byte[] eb = e.toByteArray();
	output.writeInt(eb.length);
	output.write(eb);
    }

    // Secret: (p, q, d, e)
    // Public: (n, e)

    public Key readKey(InputStream in) throws IOException {
	DataInputStream input = new DataInputStream(in);
	RSAKey key = new RSAKey();
	if(input.readBoolean()) {
	    System.out.println("Reading Secret key");
	    key.secret = true;
	    byte[] pb = new byte[input.readInt()];
	    input.read(pb);
	    key.p = new BigInteger(pb);
	    byte[] qb = new byte[input.readInt()];
	    input.read(qb);
	    key.q = new BigInteger(qb);
	    byte[] db = new byte[input.readInt()];
	    input.read(pb);
	    key.d = new BigInteger(db);
	    key.n = p.multiply(q);
	    key.phin = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	} else {
	    System.out.println("Reading Public key");
	    key.secret = false;
	    byte[] nb = new byte[input.readInt()];
	    input.read(nb);
	    key.n = new BigInteger(nb);
	}
	byte[] eb = new byte[input.readInt()];
	input.read(eb);
	key.e = new BigInteger(eb);
	return key;
    }
}

