<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Candy Information</h2>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Weight</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Manufacturer</th>
                    </tr>
                    <xsl:for-each select="candies/candy">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="weight"/></td>
                            <td><xsl:value-of select="category"/></td>
                            <td><xsl:value-of select="price/amount"/><xsl:text> </xsl:text><xsl:value-of select="price/currency"/></td>
                            <td><xsl:value-of select="manufacturer/official-name"/><br/><xsl:value-of select="manufacturer/country"/><br/><xsl:value-of select="manufacturer/address"/><br/><xsl:value-of select="manufacturer/phone"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
